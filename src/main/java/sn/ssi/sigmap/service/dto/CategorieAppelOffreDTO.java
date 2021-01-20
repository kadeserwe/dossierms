package sn.ssi.sigmap.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.CategorieAppelOffre} entity.
 */
public class CategorieAppelOffreDTO implements Serializable {
    
    private Long id;

    private String libelle;

    private Integer niveau;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategorieAppelOffreDTO)) {
            return false;
        }

        return id != null && id.equals(((CategorieAppelOffreDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CategorieAppelOffreDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", niveau=" + getNiveau() +
            "}";
    }
}
