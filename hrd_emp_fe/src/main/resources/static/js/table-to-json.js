$(document).ready(function() {

  (function($) {

    $.fn.extend({
      tableToJson: function(options) {

        var defaults = {
          separator: ',',
          newline: '\r\n',
          ignoreColumns: '',
          ignoreRows: '',
          htmlContent: false,
          consoleLog: false,
          utf8BOM: true,
        };
        var options = $.extend(defaults, options);


        function quote(text) {
          return '"' + text.replace('"', '""') + '"';
        }


        function parseString(data) {

          if (defaults.htmlContent) {
            content_data = data.html().trim();
          } else {
            content_data = data.text().trim();
          }
          return content_data;
        }

        function toJson(el) {

          var jsonHeaderArray = [];
          $(el).find('thead').find('tr').not(options.ignoreRows).each(function() {
            var tdData = "";
            var jsonArrayTd = [];
            var trimThead = "";

            $(this).find('th').not(options.ignoreColumns).each(function(index, data) {

              trimThead = (parseString($(this))).replace(/\s+/g, '_').toLowerCase();

              jsonArrayTd.push(trimThead);

              console.log(trimThead);
            });
            jsonHeaderArray.push(jsonArrayTd);

          });

          console.log("jsonHeaderArray: ", jsonHeaderArray);


          var jsonArray = [];
          $(el).find('tbody').find('tr').not(options.ignoreRows).each(function() {

            var tdData = "";
            var rowid = $(this).index();
            console.log('rowid: ' + rowid);
            var obj = {};
            $(this).find('input,select,span').not(options.ignoreColumns).each(function(index, data) {
              for (i = 0; i < jsonHeaderArray[0].length; i++) {

                if ($(this).is('input[type="checkbox"]')) {
                  if (index == i)
									 {
                    this.name = jsonHeaderArray[0][i];
										var a=this.name+rowid;
									//	alert(a);
                    	if ($(this).prop("checked") == true)
											{

                      obj[this.name] = 'true';
                      }
										 else
										  {
                      obj[this.name] = 'false';
                     }
                  }
                }
								else if ($(this).is('input[type="radio"]'))
								{
                  if (index == i)
									 {
                    this.name = jsonHeaderArray[0][i];
												var a=this.name+rowid;
                    if ($(this).is(':checked'))
										 {
                      obj[this.name] = 'true';
                     }
										 else
										 {
                      obj[this.name] = 'false';
                    }
                  }
                }
								 else
								 {
                  if (index == i)
									{
                    this.name = jsonHeaderArray[0][i];
										var a=this.name+rowid;
                    obj[this.name] = this.value;
                  }
                }
              }
            });
            obj['row'] = rowid;
            jsonArray.push(obj);
            console.log(JSON.stringify(jsonArray));
          });

          return {
            data: jsonArray
          };
        }

        var el = this;
        var dataMe;

        var jsonExportArray = toJson(el);

        if (defaults.consoleLog) {
          console.log(JSON.stringify(jsonExportArray));
        }
        dataMe = JSON.stringify(jsonExportArray);
        return dataMe;

        return this;
      }
    });
  })(jQuery);

});
