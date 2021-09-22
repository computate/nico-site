package org.computate.nico.enus.user;             

import java.util.List;

import org.computate.nico.enus.base.BaseModel;
import org.computate.nico.enus.wrap.Wrap;


/**   
 * Model: true
 * Api: true
 * Page: true
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
}
