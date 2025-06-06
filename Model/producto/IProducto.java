package producto;

import java.io.*;
import java.util.*;

public interface IProducto {

    float getPrecio();

    String getDescripcion();

    String getNombre();

    int getId();

    int getTiempoEstimado();
}