package modelo;

public class Livro extends Produto {
    private String autor;
    private int paginas;
    
    public Livro (String nome,double preco,String autor, int paginas) {
        super(nome,preco);
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }
    
    public boolean ehGrande() { // retorna true se o livro tiver mais de 200 páginas
        if (this.paginas>200) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString()+
        "\nAutor: " + getAutor()+
        "\nPaginas: " + getPaginas();
    }
    
}
