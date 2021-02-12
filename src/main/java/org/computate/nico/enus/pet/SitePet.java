package org.computate.nico.enus.pet;

import org.computate.nico.enus.cluster.Cluster;
import org.computate.nico.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Indexed: true
 * Saved: true
 * 
 * ApiTag.enUS: Pet
 * ApiUri.enUS: /api/pet
 * 
 * ApiMethod.enUS: PUTImport
 * ApiMethod.enUS: PUTMerge
 * ApiMethod.enUS: PUTCopy

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: AdminSearch
 * ApiUriAdminSearch.enUS: /api/admin/pet
 * RoleUtilisateurAdminSearch.enUS: true
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: PetPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /pet
 * 
 * AName.enUS: a pet
 * Color: pale-green
 * IconGroup: solid
 * IconName: dog
 * NameVar.enUS: pet
 * 
 * Role.enUS: SiteAdmin
 * PublicRead: true
 * 
 * Rows: 100
 **/    
public class SitePet extends SitePetGen<Cluster> {
	

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */           
	protected void _petKey(Wrap<Long> w) {
		w.o(pk);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: name of pet:
	 */           
	protected void _petName(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * Multiline: true
	 * DisplayName.enUS: How much does your pet eat?
	 */           
	protected void _petFoodAmount(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * Multiline: true
	 * DisplayName.enUS: What does your pet eat?
	 */           
	protected void _petFood(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: Is your pet sick, or need medication?
	 */           
	protected void _petSick(Wrap<Boolean> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * Multiline: true
	 * DisplayName.enUS: Additional notes for medication:
	 */           
	protected void _petMedNote(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * Multiline: true
	 * DisplayName.enUS: What would get your pet in trouble?
	 */           
	protected void _petTrouble(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: Do you want updates, if you do how many?
	 */           
	protected void _update(Wrap<Boolean> w) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * Multiline: true
	 * DisplayName.enUS: How many updates? (If any.)
	 */           
	protected void _petAmount(Wrap<String> w) {
	}
	
	@Override
	protected void _objectTitle(Wrap<String> c) {
		c.o(petName);
	}
}
 	