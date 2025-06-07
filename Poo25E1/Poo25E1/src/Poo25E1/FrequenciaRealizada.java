package Poo25E1;
import java.util.Date;


public class FrequenciaRealizada {
    private ModuloODS IDmodulo;
    private int nota;
    private Date data;
    private Estudante IDaluno;
    private Date DataCerteficado;


    public FrequenciaRealizada(ModuloODS IDmodulo, int nota, Date data, Estudante IDaluno, Date DataCerteficado) {
        this.IDmodulo = IDmodulo;
        this.nota = nota;
        this.data = data;
        this.setIDaluno(IDaluno);
        this.DataCerteficado = DataCerteficado;
    }

    
    public ModuloODS getModulo() { return IDmodulo; }
    
    public int getNota() { 
    	return nota; }
    public Date getData() { 
    	return data; }


	public Estudante getIDaluno() {
		return IDaluno;
	}


	public void setIDaluno(Estudante iDaluno) {
		IDaluno = iDaluno;
	}
}

