package si.um.feri.praktikum.jsf.graf;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.*;
import si.um.feri.praktikum.ejb.EJBMeritev;
import si.um.feri.praktikum.ejb.EJBOseba;
import si.um.feri.praktikum.vao.Meritev;
import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "grafBean")
@SessionScoped
public class GrafBean {
    @Getter
    private int idIzbraneOsebe;
    @Getter
    @Setter
    private Oseba izbranaOseba;
    @EJB
    private EJBMeritev ejbMeritev;
    @EJB
    private EJBOseba ejbOseba;

    private LineChartModel dateModel;

    public void init() {
        createDateModel();
    }

    public LineChartModel getDateModel() {
        return dateModel;
    }

    public void setDateModel(LineChartModel dateModel) {
        this.dateModel = dateModel;
    }

    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Teža");

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("ITM");

        List<Meritev> meritveOsebe = ejbMeritev.vrniMeritvePoId(idIzbraneOsebe);

        for (int i = 0; i < meritveOsebe.size(); i++) {
            addSeries(series1, series2, meritveOsebe, i);
        }

        dateModel.addSeries(series1);
        dateModel.addSeries(series2);

        dateModel.setTitle("Graf teže in ITM");
        dateModel.setZoom(true);
        dateModel.setLegendPosition("e");
        dateModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        dateModel.getAxis(AxisType.Y).setLabel("Vrednost");
        DateAxis axis = new DateAxis("Datum");
        axis.setTickAngle(-50);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date maxDate = cal.getTime();
        axis.setMax(new SimpleDateFormat("yyyy-MM-dd").format(maxDate));

        axis.setTickFormat("%b %#d, %y");

        dateModel.getAxes().put(AxisType.X, axis);
    }

    private void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Prvi datum ne sme bit za drugim datumom!"));
    }

    private void addSeries(LineChartSeries series1, LineChartSeries series2, List<Meritev> meritveOsebe, int j) {
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        String datumMeritve = format.format(meritveOsebe.get(j).getDatumVpisa());
        double itm = meritveOsebe.get(j).getTeza() / Math.pow((meritveOsebe.get(j).getVisina() / 100), 2);

        series1.set(datumMeritve, meritveOsebe.get(j).getTeza());
        series2.set(datumMeritve, zaokroziStevilo(itm));
    }

    private static double zaokroziStevilo(double stevilo) {
        long factor = (long) Math.pow(10, 2);
        stevilo = stevilo * factor;
        long tmp = Math.round(stevilo);

        return (double) tmp / factor;
    }

    public void setIdIzbraneOsebe(int idOsebe) {
        idIzbraneOsebe = idOsebe;
        izbranaOseba = ejbOseba.osebById(idOsebe);
    }

    public boolean aliImaOsebaMeritve() {
        return ejbMeritev.vrniMeritvePoId(izbranaOseba.getIdOseba()).size() > 0;
    }
}
