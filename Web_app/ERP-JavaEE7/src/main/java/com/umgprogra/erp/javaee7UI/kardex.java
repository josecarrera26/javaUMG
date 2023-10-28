package com.umgprogra.erp.javaee7UI;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Kardex;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    
    private void createBarModelKardex(){
         EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        barModelKardex = new BarChartModel();
        ChartSeries registros = new ChartSeries();
        
       TypedQuery<Kardex> query = entityManager.createQuery("SELECT k FROM Kardex k", Kardex.class);
        Iterable<Kardex> kardexlist = query.getResultList();
        for(Kardex kardex :kardexlist){
            registros.set(kardex.getIntOut(), kardex.getUnidadesVendidas());
            
        }
        barModelKardex.addSeries(registros);
        barModelKardex.setTitle("Tipo de facturacion");
        barModelKardex.setLegendPosition("ne");
        
    }
}
