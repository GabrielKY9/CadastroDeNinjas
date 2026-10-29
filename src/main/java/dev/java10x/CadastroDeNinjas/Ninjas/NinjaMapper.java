package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    //Criando um método para mapear os campos do Model para o DTO
    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgURL(ninjaDTO.getImgURL());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }

    //Criando um método para mapear os campos do DTO para o Model
    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setImgURL(ninjaModel.getImgURL());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());

        return ninjaDTO;
    }
}
