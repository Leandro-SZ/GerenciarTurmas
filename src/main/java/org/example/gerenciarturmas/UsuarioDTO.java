package org.example.gerenciarturmas;

public class UsuarioDTO {

    private String turma;
    private String turno;
    private String nomeInstrutor;

    public UsuarioDTO(String turma, String turno, String nomeInstrutor) {
        this.turma = turma;
        this.turno = turno;
        this.nomeInstrutor = nomeInstrutor;
    }

    // Getters são OBRIGATÓRIOS para a TableView funcionar
    public String getTurma() { return turma; }
    public String getTurno() { return turno; }
    public String getNomeInstrutor() { return nomeInstrutor; }
}
