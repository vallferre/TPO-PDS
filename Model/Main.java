import cliente.Cliente;
import cliente.CuponDescuento;
import cliente.Email;
import notificacion.INotificable;
import notificacion.NotificacionEmail;
import notificacion.NotificacionPush;
import pago.MetodoPago;
import pago.TarjetaCredito;
import pago.TarjetaDebito;
import producto.CategoriaProducto;
import producto.IProducto;
import producto.Producto;
import restaurante.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Producto 1: Entrada
        Producto empanada = new Producto(
                1,
                "Empanada de carne",
                "Empanada criolla con carne picada, cebolla y huevo",
                500.0f,
                List.of("Gluten", "Huevo"),
                CategoriaProducto.ENTRADA
        );

        // Producto 2: Plato principal
        Producto milanesa = new Producto(
                2,
                "Milanesa con papas",
                "Milanesa de carne con papas fritas caseras",
                1800.0f,
                List.of("Gluten", "Huevo"),
                CategoriaProducto.PLATO_PRINCIPAL
        );

        // Producto 3: Postre
        Producto helado = new Producto(
                3,
                "Helado de chocolate",
                "Helado artesanal de chocolate con almendras",
                700.0f,
                List.of("Lácteos", "Frutos secos"),
                CategoriaProducto.POSTRE
        );

        // Producto 4: Bebida
        Producto limonada = new Producto(
                4,
                "Limonada casera",
                "Limonada natural con menta y jengibre",
                450.0f,
                List.of(), // sin alérgenos
                CategoriaProducto.BEBIDA
        );

        // Producto 5: Plato vegetariano
        Producto ensalada = new Producto(
                5,
                "Ensalada César veggie",
                "Lechuga, croutons, aderezo César sin anchoas, queso",
                1200.0f,
                List.of("Gluten", "Lácteos"),
                CategoriaProducto.PLATO_PRINCIPAL
        );

        Menu menu = new Menu();

        menu.agregarProducto(empanada);
        menu.agregarProducto(milanesa);
        menu.agregarProducto(helado);
        menu.agregarProducto(limonada);
        menu.agregarProducto(ensalada);

        System.out.println("Productos del menú:");
        for (IProducto p : menu.getListaProductos()) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        System.out.println("-----------------------------------");

        Email emailCliente = new Email("franco", "@gmail.com");
        INotificable canalEmail = new NotificacionEmail(emailCliente);
        Cliente cliente = new Cliente("Franco Lovera", emailCliente, canalEmail);

        Email emailMozo = new Email("enrique", "@buensabor.com");
        INotificable notificacionPush = new NotificacionPush();
        Staff mozo = new Mozo("enrique", "11223344", emailMozo, notificacionPush);

        Email emailAdmin = new Email("maria", "@buensabor.com");
        Staff admin = new Administrativos("María López", "12345678", emailAdmin);

        Staff chef = new Chef("Carlos Gómez", "98765432", "Cocina Argentina");

        List<Staff> personal = new ArrayList<>();
        personal.add(admin);
        personal.add(chef);
        personal.add(mozo);

        Restaurante restaurante = new Restaurante(1, "El Buen Sabor", "Av. Siempreviva 123", personal);

        List<IProducto> productosSeleccionados = List.of(empanada, limonada);

        System.out.println("Tu pedido:");
        for (IProducto p : productosSeleccionados) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth vencimiento = YearMonth.parse("12/26", formato);
        MetodoPago tarjeta = new TarjetaCredito("1234-5678-9876-5432", "Franco Lovera", "Av. Lima 757", vencimiento, 123);

        CuponDescuento cupon = new CuponDescuento("DESCUENTO10", 10, new Date()); // descuento del 10%

        cliente.realizarPedido(restaurante, tarjeta, productosSeleccionados, cupon);

        System.out.println(mozo);
        System.out.println("-----------------------------------");
        System.out.println(admin);
        System.out.println("-----------------------------------");
        System.out.println(chef);

        System.out.println("-----------------------------------");

        System.out.println("Productos del menú:");
        for (IProducto p : menu.getListaProductos()) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        System.out.println("-----------------------------------");

        Email email1 = new Email("ciro03", "@gmail.com");

        INotificable canalEmail1 = new NotificacionEmail(email1);

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth vencimiento1 = YearMonth.parse("12/26", formato1);

        TarjetaDebito td = new TarjetaDebito("1223-5178-9556-5434", "Ciro Insaurralde", "Av. Lima 757", vencimiento1, 123, 1.0f);

        List<IProducto> productosSeleccionados1 = List.of(empanada, limonada);

        System.out.println("Tu pedido:");
        for (IProducto p : productosSeleccionados1) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        Cliente cliente1 = new Cliente("Insaurralde Ciro", email1, canalEmail1);

        cliente1.realizarPedido(restaurante, td, productosSeleccionados1, null);

        System.out.println("Cliente: " + cliente1.getNombre());
        System.out.println("Email: " + email1);
        for (IProducto p : productosSeleccionados1) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        System.out.println("-----------------------------------");
    }
}
