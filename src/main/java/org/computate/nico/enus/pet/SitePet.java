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
	 * DisplayName.enUS: start year
	 */           
	protected void _petName(Wrap<String> w) {
	}
}
 	