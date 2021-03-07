package org.computate.nico.enus.enrollment;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.computate.nico.enus.cluster.Cluster;
import org.computate.nico.enus.pet.SitePet;
import org.computate.nico.enus.search.SearchList;
import org.computate.nico.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Indexed: true
 * Saved: true
 * 
 * ApiTag.enUS: State
 * ApiUri.enUS: /api/enrollment
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
 * ApiUriAdminSearch.enUS: /api/admin/enrollment
 * RoleUtilisateurAdminSearch.enUS: true
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: EnrollmentPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /enrollment
 * 
 * AName.enUS: an enrollment
 * Color: red
 * IconGroup: duotone
 * IconName: clipboard-list
 * NameVar.enUS: reportCard
 * 
 * Role.enUS: SiteAdmin
 * RoleSession: true
 * RoleUser: true
 * 
 * Rows: 100
 **/  
public class SiteEnrollment extends SiteEnrollmentGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */          
	protected void _enrollmentKey(Wrap<Long> c) {
		c.o(pk);
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Attribute: SiteUser.enrollmentKeys
	 * HtmlRow: 8
	 * HtmlCell: 1
	 * DisplayName.enUS: users
	 */                            
	protected void _userKeys(List<Long> c) {}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Attribute: SitePet.enrollmentKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: pets
	 */         
	protected void _petKeys(List<Long> c) {}

	protected void _petSearch(SearchList<SitePet> l) {
		l.setQuery("*:*");
		l.addFilterQuery("enrollmentKey_indexed_long:" + pk);
		l.setC(SitePet.class);
		l.setStore(true);
	}

	protected void _pet_(Wrap<SitePet> c) {
		if(petSearch.size() > 0) {
			c.o(petSearch.get(0));
		}
	}
}
