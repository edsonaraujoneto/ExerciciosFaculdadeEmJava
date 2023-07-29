public interface Tributavel {
    public String getTipo(); //tipo de imposto, exemplo ICMS, ISS, IPTU, etc...
    public double getAliquota();
    public double getValorImposto(); 
}