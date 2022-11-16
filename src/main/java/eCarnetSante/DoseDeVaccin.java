package eCarnetSante;


import java.util.Objects;

/**
* La classe des doses de vaccin qui sont administrée à des personnes.
* Une dites dose de vaccin est administrée à une seule personne, elle est identifiable précisément par son id qui est unique .
*@author (Nael TALBI)
*/

public class DoseDeVaccin {


	private Personne personne;
	private String agentInfextieux;
	private int idDoseVaccin;
	
	public DoseDeVaccin(Personne personne, String agentInfectieux,int idDoseVaccin) {
		this.agentInfextieux = agentInfectieux;
		this.idDoseVaccin=idDoseVaccin;
		this.setPersonne(personne);
	}
	public DoseDeVaccin(String agentInfectieux,int idDoseVaccin) {
		this.agentInfextieux = agentInfectieux;
		this.idDoseVaccin=idDoseVaccin;
	}
	
	/**
	 * Permet de donner une dose du vaccin à une personne 
	 * @param personne
	 */
	
	public void setPersonne(Personne personne) {
		Personne.verifSiPersonneNull(personne);
		
		if(!personne.getListeDesVaccins().contains(this)) {
			personne.ajouterDoseDeVaccin(this);
			this.personne = personne;
		}
		this.personne=personne;
	}
	
	/**
	 * 
	 * @return La personne qui a reçu cette Dose De Vaccin .
	 */
	
	public Personne getPersonne() {
		return this.personne;
	}
	
	/**
	 * La Dose De Vaccin a un nom qui correspond à celui du virus contre lequel elle vaccine.
	 * @return le nom de l agent Infextieux que contien la dose de vaccin.
	 */
	
	public String getAgentInfextieux() {
		return agentInfextieux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agentInfextieux == null) ? 0 : agentInfextieux.hashCode());
		result = prime * result + idDoseVaccin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoseDeVaccin other = (DoseDeVaccin) obj;
		if (agentInfextieux == null) {
			if (other.agentInfextieux != null)
				return false;
		} else if (!agentInfextieux.equals(other.agentInfextieux))
			return false;
		if (idDoseVaccin != other.idDoseVaccin)
			return false;
		return true;
	}
	
	
	
}
