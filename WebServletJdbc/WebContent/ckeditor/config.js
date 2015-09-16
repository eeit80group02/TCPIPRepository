/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.skin = 'bootstrapck'
	config.toolbar = 'TabToolbar'
	config.toolbar_TabToolbar =
	[
	['Source','-','Preview','-','Cut','Copy','Paste'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Link','Unlink','Anchor'],
	['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	['Format','FontSize','-','TextColor','BGColor']
	]
	
};
