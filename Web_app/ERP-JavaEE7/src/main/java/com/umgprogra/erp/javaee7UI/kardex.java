package com.umgprogra.erp.javaee7UI;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.ui.services.KardexServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.primefaces.model.chart.AxisType;

@ManagedBean
@ViewScoped
public class kardex implements Serializable{
    
    
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    

    public BarChartModel getBarModelKardex() {
        return barModelKardex;
    }

    public void setBarModelKardex(BarChartModel barModelKardex) {
        this.barModelKardex = barModelKardex;
    }
    

    private BarChartModel barModel;
    private BarChartModel barModelKardex;

    @PostConstruct
    public void init() {
        createBarModel();
        createBarModelKardex();
        
    }


    private void createBarModel() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        barModel = new BarChartModel();
        ChartSeries productos = new ChartSeries();

        // Recupera los datos y configura la serie
        TypedQuery<Facturadet> query = entityManager.createQuery("SELECT f FROM Facturadet f", Facturadet.class);
        Iterable<Facturadet> facturaDetList = query.getResultList();

        for (Facturadet facturaDet : facturaDetList) {
            productos.set(facturaDet.getIdproducto().getNombre(), facturaDet.getCantidad());
        }

        barModel.addSeries(productos);

        // Configuración adicional del gráfico
        barModel.setTitle("Total de ventas y compras");
        barModel.setLegendPosition("ne");
    }
    


    private void createBarModelKardex() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        // Lógica para obtener datos de compra y venta
        KardexServicio compra = new KardexServicio();
        List<Object[]> compraResultList = compra.sumUnidadesCompradasPorIdProducto();

        KardexServicio venta = new KardexServicio();
        List<Object[]> ventaResultList = venta.sumUnidadesVendidasPorIdProducto();

        // Inicializar el modelo del gráfico de barras
        barModelKardex = new BarChartModel();
        ChartSeries registrosCompra = new ChartSeries();
        registrosCompra.setLabel("Compras"); 
        ChartSeries registrosVenta = new ChartSeries();
        registrosVenta.setLabel("Ventas"); 

        for (Object[] result : compraResultList) {
            Integer idProducto = (Integer) result[0];
            Long unidadesCompradas = (Long) result[1];
            Inventario producto = entityManager.find(Inventario.class, idProducto);
            String nombreProducto = producto.getNombre();
            registrosCompra.set(nombreProducto, unidadesCompradas);
        }

        for (Object[] result : ventaResultList) {
            Integer idProducto = (Integer) result[0];
            Long unidadesVendidas = (Long) result[1];
            Inventario producto = entityManager.find(Inventario.class, idProducto);
            String nombreProducto = producto.getNombre();
            registrosVenta.set(nombreProducto, unidadesVendidas);
        }

        // Agregar series al modelo del gráfico
        barModelKardex.addSeries(registrosCompra);
        barModelKardex.addSeries(registrosVenta);

        // Configurar el título y posición de la leyenda
        barModelKardex.setTitle("Ventas y compras por producto");
        barModelKardex.setLegendPosition("ne");
    }
}
