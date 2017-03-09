/*jslint browser:true, devel:true, white:true, vars:true */
/*global $:false, intel:false */
// variables para el jslint
$.producto={};
// Configuración del HOST y URL del servicio
$.producto.HOST = 'http://localhost:8080';
// $.producto.URL = '/GA-JPA/webresources/com.iesvdc.acceso.entidades.producto';
$.producto.URL = '/GP-JPA/webresources/com.iesvdc.acceso.entidades.producto';

$.producto.ProductoReadREST = function(id) {
    if ( id === undefined ) {
        $.ajax({
            url: this.HOST+this.URL,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $('#r_producto').empty();
                $('#r_producto').append('<h3>Listado de Productos</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>categorias</th>' )));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    tbody.append($('<tr />').append('<td>' + json[clave].id + '</td>',
                                '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].categoria + '</td>'));
                }
                table.append(tbody);

                $('#r_producto').append( $('<div />').append(table) );
                $('tr:odd').css('background','#CCCCCC');
            },
            error: function (xhr, status) {
                $('#r_producto').empty();
                $('#r_producto').append('<h3>Error conectando al servidor</h3>');
                $('#r_producto').append('<p>Inténtelo más tarde</p>');
            }
        });
    } else {
        $.ajax({
            url: 'http://localhost:8080/GP-JPA/webresources/com.iesvdc.acceso.entidades.producto',
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                
            },
            error: function (xhr, status) {
                this.error('Imposible leer producto','Compruebe su conexión e inténtelo de nuevo más tarde');
            }
        });
    }
};

$.producto.ProductoCreateREST = function(){
    var datos = {
        'nombre' : $("#c_po_nombre").val(),
        'categoria': $("#c_po_categoria").val(),
         
    };
    
    // comprobamos que en el formulario haya datos...
    if ( datos.nombre.length>2 && datos.categoria.length>2 ) {
        $.ajax({
            url: this.HOST+this.URL,
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function(result,status,jqXHR ) {
               // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                $.producto.ProductoReadREST();
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Producto Create','No ha sido posible crear el producto. Compruebe su conexión.');
            }
        });
        
        // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
        $.afui.clearHistory();
        // cargamos el panel con id r_producto.
        $.afui.loadContent("#r_producto",false,false,"up");
    }
    
};

$.producto.ProductoDeleteREST = function(id){
    // si pasamos el ID directamente llamamos al servicio DELETE
    // si no, pintamos el formulario de selección para borrar.
    if ( id !== undefined ) {
        id = $('#d_po_sel').val();
        $.ajax({
            url: $.producto.HOST+$.producto.URL+'/'+id,
            type: 'DELETE',
            dataType: 'json',
            contentType: "application/json",
            // data: JSON.stringify(datos),
            success: function(result,status,jqXHR ) {
               // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                $.producto.ProductoReadREST();
                // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
                $.afui.clearHistory();
                // cargamos el panel con id r_producto.
                $.afui.loadContent("#r_producto",false,false,"up");
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Producto Delete','No ha sido posible borrar el producto. Compruebe su conexión.');
            }
        });    
    } else{
        $.ajax({
            url: this.HOST+this.URL,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $('#d_producto').empty();
                var formulario = $('<div />');
                formulario.addClass('container');
                var select = $('<select id="d_po_sel" />');
                select.addClass('form-group');
                for (var clave in json){
                    select.append('<option value="'+json[clave].id+'">'+json[clave].nombre+' ' + json[clave].categoria+'</option>');
                }
                formulario.append(select);
                formulario.append('<div class="btn btn-danger" onclick="$.producto.ProductoDeleteREST(1)"> eliminar! </div>');
                $('#d_producto').append(formulario).append(select);
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Producto Delete','No ha sido posible conectar al servidor. Compruebe su conexión.');
            }
        });
    }
    
};

$.producto.ProductoUpdateREST = function(id, envio){
    if ( id === undefined ) {
        $.ajax({
            url: this.HOST+this.URL,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $('#u_producto').empty();
                $('#u_producto').append('<h3>Pulse sobre un producto</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>categorias</th>')));
                var tbody = $('<tbody />');
                for (var clave1 in json) {
                    // le damos a cada fila un ID para luego poder recuperar los datos para el formulario en el siguiente paso
                    tbody.append($('<tr id="fila_'+json[clave1].id+'" onclick="$.producto.ProductoUpdateREST('+json[clave1].id+')"/>').append('<td>' + json[clave1].id + '</td>',
                    '<td>' + json[clave1].nombre + '</td>', '<td>' + json[clave1].categoria + '</td>'));
                }
                table.append(tbody);

                $('#u_producto').append( $('<div />').append(table) );
                $('tr:odd').css('background','#CCCCCC');
            },
            error: function (xhr, status) {
                $.producto.error('Error: Producto Update','Ha sido imposible conectar al servidor.');
            }
        });
    } else if (envio === undefined ){
        var seleccion = "#fila_"+id+" td";
        var po_id = ($(seleccion))[0];
        var po_nombre = ($(seleccion))[1];
        var po_categoria = ($(seleccion))[2];
      
        
        $("#u_po_id").val(po_id.childNodes[0].data);
        $("#u_po_nombre").val(po_nombre.childNodes[0].data);
        $("#u_po_categoria").val(po_categoria.childNodes[0].data);
        
        // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
        $.afui.clearHistory();
        // cargamos el panel con id r_producto.
        $.afui.loadContent("#uf_producto",false,false,"up");
    } else {
        //HACEMOS LA LLAMADA REST
            var datos = {
                'id' : $("#u_po_id").val(),
                'nombre' : $("#u_po_nombre").val(),
                'categoria': $("#u_po_categoria").val()
                
            };

            // comprobamos que en el formulario haya datos...
            if ( datos.nombre.length>2) {
                $.ajax({
                    url: $.producto.HOST+$.producto.URL+'/'+$("#u_po_id").val(),
                    type: 'PUT',
                    dataType: 'json',
                    contentType: "application/json",
                    data: JSON.stringify(datos),
                    success: function(result,status,jqXHR ) {
                       // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                        $.producto.ProductoReadREST();
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        $.producto.error('Error: Producto Create','No ha sido posible crear el producto. Compruebe su conexión.');
                    }
                });

                // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
                $.afui.clearHistory();
                // cargamos el panel con id r_producto.
                $.afui.loadContent("#r_producto",false,false,"up");
            }
    }
};

$.producto.error = function(title, msg){
    $('#err_producto').empty();
    $('#err_producto').append('<h3>'+title+'</h3>');
    $('#err_producto').append('<p>'+msg+'</p>');
    // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
    $.afui.clearHistory();
    // cargamos el panel con id r_producto.
    $.afui.loadContent("#err_producto",false,false,"up");
};
