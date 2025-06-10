
package model.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author carol
 */
public class Curso implements Serializable {
    
    private Integer id;
    private String nome;

    public Curso() {
    }

    public Curso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + '}';
    }    
}
