package modelo;

public interface IProdutoFabricado extends IProduto {
    int getNumeroComponentes();
    IProduto getComponentes(int index);
    void setComponentes(IProduto c);
}
