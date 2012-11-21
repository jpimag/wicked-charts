package com.googlecode.wickedcharts.showcase.options;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.AxisType;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.ExportingOptions;
import com.googlecode.wickedcharts.highcharts.options.Function;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.PlotLine;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.livedata.LiveDataSeries;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.Point;

public class SplineUpdatingOptions extends Options {

  private static final long serialVersionUID = 1L;

  public SplineUpdatingOptions() {

    setChartOptions(new ChartOptions()
        .setType(SeriesType.SPLINE)
        .setMarginRight(10));

    setTitle(new Title("Live random data"));

    setxAxis(new Axis()
        .setType(AxisType.DATETIME)
        .setTickPixelInterval(150));

    setyAxis(new Axis()
        .setTitle(new Title("Value"))
        .setPlotLines(Collections.singletonList(new PlotLine()
            .setValue(0f)
            .setWidth(1)
            .setColor(new HexColor("#808080")))));

    setTooltip(new Tooltip()
        .setFormatter(new Function()
            .setFunction("return '<b>'+ this.series.name +'</b><br/>'+"
                + "Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+"
                + "Highcharts.numberFormat(this.y, 2);")));

    setLegend(new Legend(Boolean.FALSE));

    setExporting(new ExportingOptions()
        .setEnabled(Boolean.FALSE));

    addSeries(new LiveDataSeries(this, 1000) {

      @Override
      public Coordinate<Number, Number> update() {
        return new Coordinate<Number, Number>(new Date().getTime(),
            Math
                .random());
      }
    }
        .setData(randomData(20))
        .setName("Random data"));

  }

  private List<Point> randomData(int size) {
    long time = new Date()
        .getTime() - 20000;
    List<Point> result = new ArrayList<Point>();
    for (int i = 0; i < size; i++) {
      result
          .add(new Point()
              .setX(time)
              .setY(Math
                  .random()));
      time += 1000;
    }
    return result;
  }

}