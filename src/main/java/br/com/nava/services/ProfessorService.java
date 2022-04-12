package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositories.ProfessorRepository;
//Informar que a classe ProfessorService será injetada 
@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	//__________________________________________ Mostrar Todos____________________________________________________
	public List<ProfessorDTO> getAll(){
		List<ProfessorEntity> lista =  professorRepository.findAll();
		List<ProfessorDTO> listaDTO = new ArrayList<>();
		/*
		 * for (int i = 0; i < lista.size(); i++) {
			ProfessorEntity professorEntity = lista.get(i);
		}*/
		// foreach
		// 1-) Tipo da variável de cada elemento da lista
		// 2-) nome local da variável 
		// - 3 lista com elementos a ser percorrido
		for (ProfessorEntity professorEntity : lista) {				
//			ProfessorDTO dto = new ProfessorDTO();
//			dto.setId( professorEntity.getId() );
//			dto.setCep( professorEntity.getCep() );
//			dto.setCpf( professorEntity.getCpf() );
//			dto.setNome( professorEntity.getNome() );
//			dto.setNumero( professorEntity.getNumero() );
//			dto.setRua( professorEntity.getRua() );
//			listaDTO.add(dto);
			listaDTO.add(professorEntity.toDTO());
		}
		return listaDTO;		
	}
	//__________________________________________ Mostrar apenas 01_________________________________________________
	public ProfessorDTO getOne(int id) {
		Optional<ProfessorEntity> optional = professorRepository.findById(id);
		ProfessorEntity professor = optional.orElse( new ProfessorEntity() );
		return professor.toDTO();
	}
	//__________________________________________ INSERIR um novo ___________________________________________________
	public ProfessorDTO save(ProfessorEntity professor) {
		return professorRepository.save(professor).toDTO();
	}
	//__________________________________________ Atualizando os dados / UPDATE______________________________________
	public ProfessorDTO update(int id, ProfessorEntity professor ) {
																		// Primeiro é verificar se existe no banco de dados
		Optional<ProfessorEntity> optional  = professorRepository.findById(id);
																		// isPresent é o mesmo que contém, e está comparando se existe no banco de dados
		if (optional.isPresent() == true) {
			ProfessorEntity professorBD = optional.get();
			professorBD.setNome(professor.getNome());
			professorBD.setCep(professor.getCep());
			professorBD.setCpf(professor.getCpf());
			professorBD.setNumero(professor.getNumero());
			professorBD.setRua(professor.getRua());
			
			return professorRepository.save(professorBD).toDTO();
		}
		else {
																		// caso não exista no banco de dados  ele vai criar um novo objeto vario e retornar o msm 
			return new ProfessorEntity().toDTO();
		}
	}
	//__________________________________________ Deletar um endereço__________________________________________________
	public void delete(int id) {
		professorRepository.deleteById(id);
		
	}
}