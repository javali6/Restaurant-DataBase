package engine;

import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportGenerator {

    private MySQLConnector connection;
    private JasperReport jasperReport;
    private JRDataSource dataSource;
    private JasperPrint print;

    public ReportGenerator() throws SQLException {
        MySQLConnector connection = new MySQLConnector();
        this.connection = connection;
    }


    public void generateFirstReport() throws JRException, SQLException {
        generate("ReportOne.jrxml",
                Queries.REPORT_ONE_QUERY,
                "reportOne.pdf");
    }

    public void generateSecondReport(String condition) throws JRException, SQLException {
        generate("ReportTwo.jrxml",
                Queries.REPORT_TWO_QUERY + condition,
                "reportTwo.pdf");
    }

    public void generateThirdReport() throws JRException, SQLException {
        generate("ReportThree.jrxml",
                Queries.REPORT_THREE_QUERY,
                "reportThree.pdf");

    }

    public void generateFourthReport() throws JRException, SQLException {
        generate(" ",
                " ",
                "reportFour.pdf");
    }

    private void generate(String sourceFileName,
                          String reportOneQuery,
                          String destFileName) throws JRException, SQLException {
        jasperReport = JasperCompileManager.compileReport(sourceFileName);
        ResultSet resultSet = connection.executeQuery(reportOneQuery);

        dataSource = new JRResultSetDataSource(resultSet);
        print = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
        JasperExportManager.exportReportToPdfFile(print, destFileName);
    }
}
