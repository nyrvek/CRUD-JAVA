package DTO;

public class PessoaDTO {

    /*Atributos*/
    private String nome, cpf;
    private int idade;
    private float divida;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the divida
     */
    public float getDivida() {
        return divida;
    }

    /**
     * @param divida the divida to set
     */
    public void setDivida(float divida) {
        this.divida = divida;
    }
}
