package com.example.designappwebted3.service;

import com.example.designappwebted3.exception.EntityNotFoundException;
import com.example.designappwebted3.exception.MissingArgumentsException;
import com.example.designappwebted3.model.dto.HeroiDTO;
import com.example.designappwebted3.model.entity.Heroi;
import com.example.designappwebted3.model.view.HeroiView;
import com.example.designappwebted3.repository.HeroiRepository;
import com.example.designappwebted3.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiService {

    private final HeroiRepository heroiRepository;
    private final ConvertUtils convertUtils;

    public HeroiService(HeroiRepository repository, ConvertUtils convertUtils) {
        this.heroiRepository = repository;
        this.convertUtils = convertUtils;
    }

    public void cadastrarHeroi(HeroiDTO heroiDTO){

        if(heroiDTO.getNomeHeroi().equals("") || heroiDTO.getLocal().equals("")){
            throw new MissingArgumentsException("O herói precisa de um nome heróico e um local de atuação.");

        }
        this.heroiRepository.save( (Heroi)
                this.convertUtils.convertToObject(heroiDTO, Heroi.class));
    }

    public List<HeroiView> listarHerois(){

        return convertUtils
                .convertListToObject(this.heroiRepository.findAll(), HeroiView.class);
    }

    public HeroiView listarPorId(Long id){
        var entity = this.heroiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));
        return (HeroiView) convertUtils.convertToObject(entity, HeroiView.class);
    }

    public void deletarHeroi(Long id){
        try{
            this.heroiRepository.deleteById(id);
        }catch (Exception e){
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }

    public void atualizar(Long id, HeroiDTO heroiRequest){

        var entity = this.heroiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));

        var entityUpdated = (Heroi)
                convertUtils.convertToObject(heroiRequest, entity.getClass());
        entityUpdated.setId(id);

        this.heroiRepository.save(entityUpdated);
    }

}
