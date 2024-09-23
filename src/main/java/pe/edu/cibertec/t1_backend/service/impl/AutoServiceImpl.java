package pe.edu.cibertec.t1_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1_backend.dto.AutoRequestDTO;
import pe.edu.cibertec.t1_backend.service.AutoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] verificarPlaca(AutoRequestDTO request) throws IOException {
        String[] datosAuto = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String line;
            while ((line = br.readLine()) != null){
                String[] datos=line.split(";");
                if(request.placa().trim().equalsIgnoreCase(datos[1].trim())){
                    datosAuto = new String[5];
                    datosAuto[0] = datos[2];
                    datosAuto[1] = datos[3];
                    datosAuto[2] = datos[4];
                    datosAuto[3] = datos[5];
                    datosAuto[4] = datos[6];
                }
            }
        }catch (IOException e){
            datosAuto=null;
            throw new IOException(e);
        }
        return datosAuto;
    }
}
