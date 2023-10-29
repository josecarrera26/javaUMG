/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services.reportes;

import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.util.JpaUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author hccon
 */

@ManagedBean
@ViewScoped
public class ReporteFactura implements Serializable{
    
    
    private Integer idfactura;

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }
    
 
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public void generarReporte(ActionEvent pActionEvent) {
        System.out.println("Ingresa generarReporte");
        try {
                
            List<Facturadet> resultados = null;

            Query query2 = entity.createNamedQuery("Facturadet.findByIdtransaccion", Facturadet.class)
                    .setParameter("idtransaccion", this.idfactura);

            resultados = query2.getResultList();

            Locale locale = new Locale("es", "GT");
            Map<String, Object> masterParams = new HashMap<>();
            masterParams.put(JRParameter.REPORT_LOCALE, locale);

            String reportPath = this.getRealPath("reportes/ReporteFactura.jasper");
            System.out.println("ruta del reporte: " + reportPath);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            String logoPath = this.getRealPath("resources/images/Logo.png");
            System.out.println("ruta del logo: " + logoPath);
            masterParams.put("logo", logoPath);

            //resultados, es la fuente de datos que resulta de la query a la db.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, masterParams, new JRBeanCollectionDataSource(resultados));
            System.out.println("si llena el reporte con los parametros");
            
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporteFactura.pdf");
            httpServletResponse.setContentType("application/pdf");
            
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            
            //revisar.
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (IOException | JRException e) {
            System.err.println("Error al generar reporte web " + e.getMessage());
        }
    }

    /**
     * metodo para tener el path absoluto de un directorio
     *
     * @param pUbicacion
     * @return
     */
    private String getRealPath(String pUbicacion) {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath(pUbicacion);
    }

}