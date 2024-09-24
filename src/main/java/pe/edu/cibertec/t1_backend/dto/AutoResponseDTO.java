package pe.edu.cibertec.t1_backend.dto;

public record AutoResponseDTO(
        String codigo,
        String mensaje,
        String marca,
        String modelo,
        String nroAsientos,
        String precio,
        String color) {
}
