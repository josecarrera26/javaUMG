package com.umgprogra.erp.javaee7UI;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.ui.services.KardexServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class kardex implements Serializable{

    public BarChartModel getBarModelKardexVenta() {
        return barModelKardexVenta;
    }

    public void setBarModelKardexVenta(BarChartModel barModelKardexVenta) {
        this.barModelKardexVenta = barModelKardexVenta;
    }

    public BarChartModel getBarModelKardexCompra() {
        return barModelKardexCompra;
    }

    public void setBarModelKardexCompra(BarChartModel barModelKardexCompra) {
        this.barModelKardexCompra = barModelKardexCompra;
    }

    public PieChartModel getModeloCircular() {
        return modeloCircular;
    }

    public void setModeloCircular(PieChartModel modeloCircular) {
        this.modeloCircular = modeloCircular;
    }

    public Long getResultadosVenta() {
        return resultadosVenta;
    }

    public void setResultadosVenta(Long resultadosVenta) {
        this.resultadosVenta = resultadosVenta;
    }

    public Long getResultadosCompra() {
        return resultadosCompra;
    }

    public void setResultadosCompra(Long resultadosCompra) {
        this.resultadosCompra = resultadosCompra;
    }

    public BarChartModel getBarModelKardexVentaFecha() {
        return barModelKardexVentaFecha;
    }

    public void setBarModelKardexVentaFecha(BarChartModel barModelKardexVentaFecha) {
        this.barModelKardexVentaFecha = barModelKardexVentaFecha;
    }

    public BarChartModel getBarModelKardexCompraFecha() {
        return barModelKardexCompraFecha;
    }

    public void setBarModelKardexCompraFecha(BarChartModel barModelKardexCompraFecha) {
        this.barModelKardexCompraFecha = barModelKardexCompraFecha;
    }
  
    
    

    @Override
    public String toString() {
        return "kardex{" + "barModelKardexVenta=" + barModelKardexVenta + ", barModelKardexCompra=" + barModelKardexCompra + '}';
    }
    
    
    

    //para el grafico de barras 
    private BarChartModel barModelKardexVenta;
    private BarChartModel barModelKardexCompra;
    
      private BarChartModel barModelKardexVentaFecha;
    private BarChartModel barModelKardexCompraFecha;

    //para el gradico circultar
    private PieChartModel modeloCircular;

    private Long resultadosVenta;
    private Long resultadosCompra;

    @PostConstruct
    public void init() {

        barModelKardexCompra = new BarChartModel();
        barModelKardexVenta = new BarChartModel();
        barModelKardexVentaFecha = new BarChartModel();
        barModelKardexCompraFecha = new BarChartModel();
        modeloCircular = new PieChartModel();
       
        createBarModelKardexFecha();
        createBarModelKardex();
        cargarDatosGraficoCircular();
    }

    // Método para cargar datos en el modelo del gráfico circular
    private void cargarDatosGraficoCircular() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        KardexServicio servicio = new KardexServicio();
        resultadosVenta = servicio.sumTotalUnidadesVendidas();
        resultadosCompra = servicio.sumUnidadesCompradas();

        modeloCircular.set("Unidades Vendidas", resultadosVenta);
        modeloCircular.set("Unidades Compradas", resultadosCompra);
    }


    private void createBarModelKardex() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        // Lógica para obtener datos de compra y venta
        KardexServicio compra = new KardexServicio();
        List<Object[]> compraResultList = compra.sumUnidadesCompradasPorIdProducto();

        KardexServicio venta = new KardexServicio();
        List<Object[]> ventaResultList = venta.sumUnidadesVendidasPorIdProducto();

        // Inicializar el modelo del gráfico de barras
        barModelKardexCompra = new BarChartModel();

        // Crear una serie para compras y ventas
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

            // Agregar un elemento a la serie con el nombre del producto
            registrosVenta.set(nombreProducto, unidadesVendidas);
        }

        // Agregar series al modelo del gráfico
        barModelKardexCompra.addSeries(registrosCompra);
        barModelKardexVenta.addSeries(registrosVenta);

        // Configurar el título y posición de la leyenda de compra
        barModelKardexCompra.setTitle("Top 8 Productos mas comprados");
        barModelKardexCompra.setLegendPosition("ne");

        // Configurar etiquetas en el eje X
        Axis xAxis = barModelKardexCompra.getAxis(AxisType.X);
        xAxis.setLabel("Productos comprados");
        xAxis.setTickAngle(-30);
        
        
        // Configurar el título y posición de la leyenda de venta
        barModelKardexVenta.setTitle("Top 8 Productos mas vendidos");
        barModelKardexVenta.setLegendPosition("ne");
        
        Axis xAxisCompra = barModelKardexVenta.getAxis(AxisType.X);
        xAxisCompra.setLabel("Productos vendidos");
        xAxisCompra.setTickAngle(-30);

    }
    
    // GRAFICA POR FECHA
    private void createBarModelKardexFecha() {

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        // Lógica para obtener datos de compra y venta
        KardexServicio compra = new KardexServicio();
        List<Object[]> compraResultList = compra.sumUnidadesCompradasPorfecha();

        KardexServicio venta = new KardexServicio();
        List<Object[]> ventaResultList = venta.sumUnidadesVendidasPorfecha();

        // Inicializar el modelo del gráfico de barras
        barModelKardexCompraFecha = new BarChartModel();

        // Crear una serie para compras y ventas
        ChartSeries registrosCompra = new ChartSeries();
        registrosCompra.setLabel("Compras");

        ChartSeries registrosVenta = new ChartSeries();
        registrosVenta.setLabel("Ventas");

        for (Object[] result : compraResultList) {
            Date fecha = (Date) result[0];
            Long unidadesCompradas = (Long) result[1];

            String fechaLegible = formatoFecha.format(fecha);

            registrosCompra.set(fechaLegible, unidadesCompradas);
        }

        for (Object[] result : ventaResultList) {
            Date fecha = (Date) result[0];
            Long unidadesVendidas = (Long) result[1];

            String fechaLegible = formatoFecha.format(fecha);

            registrosVenta.set(fechaLegible, unidadesVendidas);
        }

        // Agregar series al modelo del gráfico
        barModelKardexCompraFecha.addSeries(registrosCompra);
        barModelKardexCompraFecha.addSeries(registrosVenta);

        // Configurar el título y posición de la leyenda de compra
        barModelKardexCompraFecha.setTitle("Ventas y compras por fecha");
        barModelKardexCompraFecha.setLegendPosition("ne");

        // Configurar etiquetas en el eje X
        Axis xAxis = barModelKardexCompraFecha.getAxis(AxisType.X);
        xAxis.setLabel("Registro de entradas y salidas");
        xAxis.setTickAngle(-30);

    }

}
