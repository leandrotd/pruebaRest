package es.leandro.modelo.sevices;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(UploadFileService.class);
	private final static String DIRECTORIO_UPLOAD = "uploads";

	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {
		Path ruta = getPath(nombreFoto);
		log.info(ruta.toString());

		Resource recurso = new UrlResource(ruta.toUri());

		if (!recurso.exists() && !recurso.isReadable()) {
			ruta = Paths.get("src/main/resources/static/images").resolve("noImage.png").toAbsolutePath();

			recurso = new UrlResource(ruta.toUri());

			log.error("error al cargar la imagen " + nombreFoto);
		}
		return recurso;
	}

	@Override
	public String copiar(MultipartFile archivo) throws IOException {
		String nomArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename().replace(" ", "");
		Path ruta = getPath(nomArchivo);
		log.info(ruta.toString());
		
		Files.copy(archivo.getInputStream(), ruta);
		
		return nomArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto) {
		if (nombreFoto != null && nombreFoto.length() > 0) {
			File archAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath().toFile();
			if (archAnterior.exists() && archAnterior.canRead()) {
				archAnterior.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String nombreFoto) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
	}

}
