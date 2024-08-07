package br.com.andersonbalieiro.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.andersonbalieiro.gestao_vagas.modules.candidate.dto.ProfileCandidateReponseDTO;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public void execute(UUID iCandidate){
        var candidate = this.candidateRepository.findById(iCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = ProfileCandidateReponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId())
        .build();

        return candidateDTO;
    }
}
