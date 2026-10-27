package br.senac.sp.tads.dsw.exemplo6.dto;

import br.senac.sp.tads.dsw.exemplo6.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
    @NotBlank  String login,
    @NotBlank String senha, 
    @NotNull UserRole role
) {
    
}
