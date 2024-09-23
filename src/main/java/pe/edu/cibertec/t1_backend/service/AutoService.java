package pe.edu.cibertec.t1_backend.service;

import pe.edu.cibertec.t1_backend.dto.AutoRequestDTO;

import java.io.IOException;

public interface AutoService {
    String[] verificarPlaca(AutoRequestDTO request) throws IOException;
}
