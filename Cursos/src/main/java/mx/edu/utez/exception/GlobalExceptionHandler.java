package mx.edu.utez.exception;

import java.util.Date;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;


@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	//Handle specific exceptions
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		return new ResponseEntity(detallesError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(APIException.class)
	//Handle specific exceptions
	public ResponseEntity<?> handleAPIException
	(APIException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		logger.warn("Recurso no encontrado");
		return new ResponseEntity(detallesError,HttpStatus.NOT_FOUND);
	}
	
	//Handle global exceptions
	@ExceptionHandler(Exception.class)

	public ResponseEntity<?> handleException
	(ResourceNotFoundException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		logger.warn("Error interno del servidor");
		return new ResponseEntity(detallesError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//Handle @Valid and validationConstraint exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationHandling(MethodArgumentNotValidException exception){
		DetallesError detallesError = new DetallesError(new Date(), "Error de validación de datos", exception.getBindingResult().getFieldError().getDefaultMessage());
		logger.warn("Error de validacion de datos");
		return  new ResponseEntity(detallesError,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity handleMultipartException(MultipartException exception) {
		DetallesError detallesError = new DetallesError(new Date(), "Error al subir la imagen", exception.getMostSpecificCause().getMessage());
		logger.warn("Error al subir imagen");
		return  new ResponseEntity(detallesError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(FileUploadException.class)
	public ResponseEntity handleFileException(FileUploadException exception) {
		DetallesError detallesError = new DetallesError(new Date(), "Error al subir la imagen", exception.getLocalizedMessage());
		logger.warn("Error al subir imagen");
		return  new ResponseEntity(detallesError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
