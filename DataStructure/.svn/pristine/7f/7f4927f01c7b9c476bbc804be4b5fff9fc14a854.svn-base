<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html>
<head>

<script type="text/javascript">
	var weeks=[];
	var weekList = "${weekList}";
	//data
	var initGoalContarctData = [];
	var initGoalYearSalesData = [];
	var initGoalNetSalesData = [];
	var initGoalSalesProfitData = [];
	var initContarctData = [];
	var initYearSalesData = [];
	var initNetSalesData = [];
	var initSalesProfitData = [];
	
	var i = 0;
	<c:forEach var="week" items="${weekChartList.keySet()}">
		weeks.push("${week}");
		initGoalContarctData.push({x : i, y : (Math.cos(i/52*3.14 + 3.14)+1)*"${weekChartList.get(week).goalContract}"/2});
		initGoalYearSalesData.push({x : i, y : (Math.cos(i/52*3.14 + 3.14)+1)*"${weekChartList.get(week).goalYearSales}"/2});
		initGoalNetSalesData.push({x : i, y : (Math.cos(i/52*3.14 + 3.14)+1)*"${weekChartList.get(week).goalNetSales}"/2});
		initGoalSalesProfitData.push({x : i, y : (Math.cos(i/52*3.14 + 3.14)+1)*"${weekChartList.get(week).goalSalesProfit}"/2});
		initContarctData.push({x :i, y : "${weekChartList.get(week).contract}"});
		initYearSalesData.push({x : i, y : "${weekChartList.get(week).yearSales}"});
		initNetSalesData.push({x : i, y : "${weekChartList.get(week).netSales}"});
		initSalesProfitData.push({x : i, y : "${weekChartList.get(week).profit}"});
		i++;
	</c:forEach>

	nv.addGraph(function() {
	 	 
	  var chart = nv.models.lineChart()
	                .margin({left: 100})  //Adjust chart margins to give the x-axis some breathing room.
	                .useInteractiveGuideline(true)  //We want nice looking tooltips and a guideline!
	                .transitionDuration(350)  //how fast do you want the lines to transition?
	                .showLegend(true)       //Show the legend, allowing users to turn on/off line series.
	                .showYAxis(true)        //Show the y-axis
	                .showXAxis(true)        //Show the x-axis
	  ;

	  chart.xAxis     //Chart x-axis settings
	      .axisLabel('주(week)').tickFormat((d3).format(','));
 
 
	 /* chart.xAxis     //Chart x-axis settings
	 .axisLabel('주차').tickFormat(function(weeks) {
		 var dx = weeks || ""
		 console.log(weeks);
	   	 return d3.time.format("%Y-%m-%d")(new Date(dx))}); */

	  chart.yAxis     //Chart y-axis settings
	      .axisLabel('금액')
	      .tickFormat(d3.format('.01f'));

	  /* Done setting the chart up? Time to render it!*/
	  var myData = weekChartData();   //You need data...
	  
	  /* var x_domain = d3.extent(weekList, function(d) { return d.weekList; });*/
	  
	  d3.select('#chart svg')    //Select the <svg> element you want to render the chart in.   
	      .datum(myData)         //Populate the <svg> element with chart data...
	      .call(chart);          //Finally, render the chart!

	  //Update the chart when window resizes.
	  nv.utils.windowResize(function() { chart.update() });
	  return chart;
	});
	/**************************************
	 * Simple test data generator
	 */
	function weekChartData() {
	  	weeks = [];
		
	  	/* initGoalContarctData.forEach(function(value){
			console.log(value.x);
			console.log(value.y)
		}); */
		
	
	  //Line chart data should be sent as an array of series objects.
	  return [
	    {
	      values: initGoalContarctData,      //values - represents the array of {x,y} data points
	      key: '계약목표', //key  - the name of the series.
	      color: '#ff7f0e',  //color - optional: choose your own line color.
	      strokeWidth :15
	    },
	    {
	      values: initGoalYearSalesData,
	      key: '매출목표',
	      color: '#2ca02c'
	    },
	    {
	      values: initGoalNetSalesData,
	      key: '순매출목표',
	      color: '#7777ff',
	    },
		{
		   values: initGoalSalesProfitData,
		   key: '영업이익목표',
		   color: '#FF0000',
		},
	    {
		   values: initContarctData,
		   key: '계약누계',
		   color: '#ff7f0e',
		   strokeWidth: 10
		},
		{
		   values: initYearSalesData,
		   key: '매출누계',
		   color: '#2ca02c',
		},
		{
		   values: initNetSalesData,
		   key: '순매출누계',
		   color: '#7777ff',
		},
		{
		   values: initSalesProfitData,
		   key: '영업이익누계',
		   color: '#FF0000',
		}
			 
	  ];
	}
	</script>
</head>

<div id="chart">
	<svg></svg>
</div>