/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */
CKEDITOR.config.extraPlugins += "base64image";
CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.height = 500;
	config.charLimit = 1;
	config.toolbar = 'TabToolbar'
	config.toolbar_TabToolbar =
	[
	['Source','-','Preview','-','Cut','Copy','Paste'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Link','Unlink','Anchor'],
	['base64image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	['Format','FontSize','-','TextColor','BGColor']
	]
	
};
