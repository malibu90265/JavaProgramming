function getExcel(selObj,filename) {
	var html = selObj.html();
		html = html.replace(/<\/?!?(img|a)[^>]*>/g, "");     // a태그 및 img태그 제거 (정규표현식 사용)
	var a = document.createElement('a');
	var data_type = 'data:application/vnd.ms-excel';
	var table_html = encodeURIComponent(html);
		a.href = data_type + ', ' + table_html;
		a.download = filename + ".xls";
		a.click();
		// e.preventDefault();
}



function getImage(selObj) {
	  var exportSettings = {
			  fileName: "abc.png", // name of the file
			  backgroundColor: "white", // background color of PNG image
			  transparent: true // use transparency or not
	  	};
	  			var useCustomSize = true; // use
																		// custom
																		// or
																		// original
																		// size
		if (useCustomSize) {
			exportSettings.size = "Custom"; // custom size is used
			exportSettings.width = '100'; // custom image width
			exportSettings.height = '100'; // custom image height
			exportSettings.resizingMode = "Fit"; // resizing mode
			exportSettings.cutExtraSpace = true; // cut
																				// extra
																				// space
																				// settings
		} else {
			exportSettings.size = "Original"; // use original size
		}
		chart.exportAsPNG(exportSettings);

}