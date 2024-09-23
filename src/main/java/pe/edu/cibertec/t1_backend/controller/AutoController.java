package pe.edu.cibertec.t1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1_backend.dto.AutoRequestDTO;
import pe.edu.cibertec.t1_backend.dto.AutoResponseDTO;
import pe.edu.cibertec.t1_backend.service.AutoService;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    AutoService autoService;

    @PostMapping("/verificacion")
    public AutoResponseDTO verificarPlaca(@RequestBody AutoRequestDTO request) {
        try{
            String[] datosAuto = autoService.verificarPlaca(request);
            if(datosAuto==null){
                return new AutoResponseDTO("01","No se encontró un vehículo para la placa ingresada","","","","","");
            }
            return new AutoResponseDTO("00","",datosAuto[0],datosAuto[1],datosAuto[2],datosAuto[3],datosAuto[4]);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new AutoResponseDTO("99","Ocurrió un error al procesar su solicitud","","","","","");
        }
    }
}
