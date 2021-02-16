package clases;

public class Libro {
	private String isbn = null; 
	private String autor = null;
	private String titulo = null;
	private String paginas = null;

public void obtenerisbn(String isbn2) {
	isbn = isbn2;
}

public String getisbn() {
	return isbn;
}

public void obtenerautor(String autor2) {
	autor = autor2;
}

public void obtenertitulo(String titulo2) {
	titulo = titulo2;
}

public void obtenerpagina(String paginas2) {
	paginas = paginas2;
}

public void print() {
	System.out.println("El libro "+titulo+" tiene "+paginas+" p+aginas "
			+ " fue escrito por "+autor+" su ISBN es "+isbn);
}

}