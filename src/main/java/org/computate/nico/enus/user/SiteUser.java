package org.computate.nico.enus.user;                          

import java.util.List;

import org.computate.nico.enus.base.BaseModel;
import org.computate.nico.enus.wrap.Wrap;


/**   
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Map.Integer.sqlSort: 3
 * 
 * ApiTag.enUS: User
 * ApiUri.enUS: /api/user
 * 
 * ApiMethod.enUS: Search
 * ApiMethod: PATCH
 * ApiMethod: POST
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: SiteUserPage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /user
 * 
 * Keyword: classSimpleNameSiteUser
 * Role.enUS: SiteAdmin
 * Filter: userId
 * Saves: true
 * 
 * AName.enUS: a site user
 * Color: gray
 * IconGroup: regular
 * IconName: user-cog
 * NameVar.enUS: user
 * 
 * RoleUser: true
 * Role.enUS: SiteAdmin
 */     
public class SiteUser extends SiteUserGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */
	protected void _userKeys(List<Long> l) {
		l.add(pk);
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 */                 
	protected void _userId(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 */
	protected void _userName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 */
	protected void _userEmail(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 */
	protected void _userFirstName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 */
	protected void _userLastName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 */
	protected void _userFullName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * NomAffichage.enUS: receive email
	 */
	protected void _userReceiveEmails(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: see archived
	 */
	protected void _seeArchived(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * DisplayName.enUS: see deleted
	 */
	protected void _seeDeleted(Wrap<Boolean> c) {
		c.o(false);
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Relate: SitePet.userKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: pets
	 */                            
	protected void _petKeys(List<Long> c) {}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Relate: SiteEnrollment.userKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: enrollments
	 */                             
	protected void _enrollmentKeys(List<Long> c) {}

	@Override
	protected void _objectTitle(Wrap<String> c) {
		c.o(String.format("%s (%s) <%s>", userFullName, userName, userEmail));
	}
}
