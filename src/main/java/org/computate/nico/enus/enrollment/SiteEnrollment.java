package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.cluster.Cluster;
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
 * Color: pale-green
 * IconGroup: regular
 * IconName: edit
 * NameVar.enUS: reportCard
 * 
 * Role.enUS: SiteAdmin
 * PublicRead: true
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
}
