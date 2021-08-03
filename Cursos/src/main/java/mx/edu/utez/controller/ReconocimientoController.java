package mx.edu.utez.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import mx.edu.utez.entity.InscripcionEntity;
import mx.edu.utez.service.InscripcionService;
import mx.edu.utez.service.UsuarioService;


@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class ReconocimientoController {
	@Autowired
    ServletContext servletContext;
	
	@Autowired
	InscripcionService inscripcionService;
	
	@Autowired
	UsuarioService usuarioService;
	
	private final TemplateEngine templateEngine;

	public ReconocimientoController(TemplateEngine templateEngine) {
	     this.templateEngine = templateEngine;
	}

    /*@RequestMapping(path = "/")
    public String getOrderPage(Model model) {
        InscripcionEntity order = new CursoEntity();
        model.addAttribute("orderEntry", order);
        return "order";
    }*/

	@GetMapping("/pdf/{idOferta}")
    public ResponseEntity<?> getPDF(@PathVariable("idOferta") int idOferta,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	List<InscripcionEntity > prueba = inscripcionService.getReconocimientoLiberado(4);
	
		
	InscripcionEntity inscripcion = inscripcionService.getinscInscripcionEntity(idOferta);
	

    WebContext context = new WebContext(request, response, servletContext);
    context.setVariable("Inscripcion", inscripcion);
    String orderHtml = templateEngine.process("pdf", context);


    ByteArrayOutputStream target = new ByteArrayOutputStream();
    ConverterProperties converterProperties = new ConverterProperties();
    converterProperties.setBaseUri("http://localhost:8090");
    HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

    byte[] bytes = target.toByteArray();


    return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reconocimiento_SACA.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);
    }
	

}
