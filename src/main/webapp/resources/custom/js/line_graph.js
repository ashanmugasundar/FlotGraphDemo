var date = "";
var source = "";

$(document).ready(function () {
	
	source = 'Chennai';
	date = '2016-06-06';//moment().format("YYYY-MM-DD");//Current date for now !!
	
	//call drawGraph() method
	drawDailyOrderFlowStatistics();
});
    
//Drawing daily flot-line graph
function drawDailyOrderFlowStatistics(){
	$.ajax({
		
		url: 'getOrderCountForLineChart?source='+source+'&date='+date, 
		success: function(result){	    		
			var data=[];
			for(var i=0;i<result.length;i++){
				data.push([new Date(result[i]["timestamp"]).getTime(), result[i]["orderCount"]]);
			}
			var options = {
	    		     yaxis: {
	    		     },
			        series: {
			            shadowSize: 0,// drawing is faster without shadows
			            color: "#b22222" 
			        	},
	    		     xaxis: { 
	    		   		mode: "time"
	    		     },
	    		     grid: {
	    		    	 borderColor: "#633200",
	    	             backgroundColor: { colors: ["#FFFFFF", "#faebd7"] },
	    	         	 hoverable: true //IMPORTANT! this is needed for tooltip to work
	    		     },
	    		     tooltip: true,
	    		     tooltipOpts: {
	    		    	 content: "Order Count -  %y, Time - %x"
	    		     }
	    		};
	    	$.plot($("#test-line-graph"), [data], options);	    		
		}
	});	        	
}