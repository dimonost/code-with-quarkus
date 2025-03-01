package ru.mts.services;

import io.quarkus.arc.ArcContainer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import ru.mts.dto.JustRow;
import ru.mts.entity.JustUser;
import ru.mts.repository.JustUserRepository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class JasperService {
    @Inject
    JustUserRepository justUserRepository;

    public void justCompile() throws JRException {
        InputStream employeeReportStream
                = getClass().getResourceAsStream("/employeeReport.jrxml");
        JasperReport jasperReport
                = JasperCompileManager.compileReport(employeeReportStream);
        JRSaver.saveObject(jasperReport, "employeeReport.jasper");
    }

    public byte[] getPdf() throws JRException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass()
                .getResourceAsStream("/employeeReport.jasper"));

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report");

        List<JustUser> data = justUserRepository.listAll();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
