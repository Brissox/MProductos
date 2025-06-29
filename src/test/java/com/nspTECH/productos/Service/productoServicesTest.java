package com.nspTECH.productos.Service;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.nspTECH.productos.model.producto;
import com.nspTECH.productos.repository.productoRepository;
import com.nspTECH.productos.services.productoService;

public class productoServicesTest {

    
    @Mock
    private productoRepository productorepository;
    
    @InjectMocks
    private productoService productoservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    
    @Test
    public void testBuscarTodo(){
    java.util.List<producto> lista = new  ArrayList<>();

    producto prod1 = new producto();
    producto prod2 = new producto();

    prod1.setId_producto(11L);
    prod1.setNombre("Monster");
    prod1.setDescripcion("Energetica");
    prod1.setMarca("coca-cola");
    prod1.setPrecio(1600L);
    prod1.setSku("m0n5ter");
    prod1.setEstado('A');
    
    prod2.setId_producto(12L);
    prod2.setNombre("Redbull");
    prod2.setDescripcion("Energetica");
    prod2.setMarca("Redbull");
    prod2.setPrecio(2000L);
    prod2.setSku("ReDbULl");
    prod2.setEstado('A');
    

    lista.add(prod1);
    lista.add(prod2);

    when(productorepository.findAll()).thenReturn(lista);

    java.util.List<producto> resultadoBusqueda = productoservices.BuscarTodoProducto();

    assertEquals(2,resultadoBusqueda.size());
    verify(productorepository, times(1)).findAll();

}

    @Test
    public void testBuscarUnProducto(){
    producto prod = new producto();

    prod.setId_producto(11L);
    prod.setNombre("Monster");
    prod.setDescripcion("Energetica");
    prod.setMarca("coca-cola");
    prod.setPrecio(1600L);
    prod.setSku("m0n5ter");
    prod.setEstado('A');

    when(productorepository.findById(11L)).thenReturn(Optional.of(prod));

    producto prodBuscado = productoservices.BuscarUnProducto(11L);
    assertEquals(11L,prodBuscado.getId_producto());
    verify(productorepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarProducto(){
        producto prod = new producto();
        prod.setId_producto(11L);
        prod.setNombre("Monster");
        prod.setDescripcion("Energetica");
        prod.setMarca("coca-cola");
        prod.setPrecio(1600L);
        prod.setSku("m0n5ter");
        prod.setEstado('A');
            
        when(productorepository.save(any())).thenReturn(prod);

        producto prodGuardados = productoservices.GuardarProducto(prod);
        assertEquals('A', prodGuardados.getEstado());
        verify(productorepository, times(1)).save(prod);

    }

    @Test
    public void testEditarProducto(){

        producto productoO = new producto();
        productoO.setId_producto(11L);
        productoO.setSku("12321aasd");
        productoO.setDescripcion("Malo");

        producto productoE = new producto();
        productoE.setId_producto(11L);
        productoE.setSku("3344asd");
        productoE.setDescripcion("Bueno");

        when(productorepository.save(any(producto.class))).thenReturn(productoE);
        when(productorepository.existsById(11L)).thenReturn(true);
        producto resultado = productoservices.GuardarProducto(productoE);

        assertNotNull(resultado);
        assertEquals(11L, resultado.getId_producto());
        assertEquals("3344asd", resultado.getSku());
        assertEquals("Bueno", resultado.getDescripcion());

        verify(productorepository, times(1)).save(productoE);
    }

    @Test
    public void testEliminarProducto(){
        Long id = 11L;
        doNothing().when(productorepository).deleteById(id);

        productoservices.EliminarProducto(11L);

        verify(productorepository, times(1)).deleteById(id);

    }
}


