# BibliotecaNacional

Esta aplicación ha sido desarrollada con el objetivo de proporcionar un buscador de libros, este buscador ha sido implementado mediante un SearchView, al realizar la búsqueda,
mediante Retrofit se realiza la consulta a la respectiva Rest Api, si no se encuentran libros que coincidan con la búsqueda, se muestra un mensaje al usuario con esta información,
de lo contrario, los libros obtenidos utilizando gson para la deserializción, se muestran en un RecyclerView, al tocar un libro del listado, se inicia una pantalla en la que se muestra 
el detalle del libro seleccionado, para cargar las imágenes de cada libro se utiliza la librería Picasso.
