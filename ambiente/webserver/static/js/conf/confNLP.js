$( document ).ready(function(){
	$("#confNLP").click(function(e) {
        var jitHeight = "400px";
        $.ajax('/conf/nlp', {
            dataType: 'text',
            success: function (data) {
                 $.colorbox({
                        html:"<div> \
                                <div id='confNLPTree' class='jit-container' style='height:"+ jitHeight +"'></div>" +
                                    data +
                                "</div> \
                             </div>",
                        top:"0px",
                        width:"90%",
                });
                setTimeout(function(){
                    initConfNLP();  
                },1000);
            }
        });
	});	
});



(function() {
  var ua = navigator.userAgent,
      iStuff = ua.match(/iPhone/i) || ua.match(/iPad/i),
      typeOfCanvas = typeof HTMLCanvasElement,
      nativeCanvasSupport = (typeOfCanvas == 'object' || typeOfCanvas == 'function'),
      textSupport = nativeCanvasSupport 
        && (typeof document.createElement('canvas').getContext('2d').fillText == 'function');
  //I'm setting this based on the fact that ExCanvas provides text support for IE
  //and that as of today iPhone/iPad current text support is lame
  labelType = (!nativeCanvasSupport || (textSupport && !iStuff))? 'Native' : 'HTML';
  nativeTextSupport = labelType == 'Native';
  useGradients = nativeCanvasSupport;
  animate = !(iStuff || !nativeCanvasSupport);
})();

/*var Log = {
  elem: false,
  write: function(text){
    if (!this.elem) 
      this.elem = document.getElementById('log');
    this.elem.innerHTML = text;
    this.elem.style.left = (500 - this.elem.offsetWidth / 2) + 'px';
  }
};*/


var labelType, useGradients, nativeTextSupport, animate
function initConfNLP(){
	console.log("configurando");
    //init data
    var json = {
        id: "init",
        name: "Inicio",
        data: {},
        children: []
    };
    var subtree = json.children.pop();
    //end
    var removing = false;
    //init Spacetree
    //Create a new ST instance
    var st = new $jit.ST({
        'injectInto': 'confNLPTree',
        //add styles/shapes/colors
        //to nodes and edges
        
        //set overridable=true if you want
        //to set styles for nodes individually 
        Node: {
          overridable: true,
          width: 60,
          height: 20,
          color: '#ccc'
        },
        //change the animation/transition effect
        transition: $jit.Trans.Quart.easeOut,
        
        onBeforeCompute: function(node){
            //Log.write("loading " + node.name);
        },
        
        onAfterCompute: function(node){
            //Log.write("done");
        },

        //This method is triggered on label
        //creation. This means that for each node
        //this method is triggered only once.
        //This method is useful for adding event
        //handlers to each node label.
        onCreateLabel: function(label, node){
            //add some styles to the node label
            var style = label.style;
            label.id = node.id;
            style.color = '#333';
            style.fontSize = '0.8em';
            style.textAlign = 'center';
            style.width = "60px";
            style.height = "20px";
            label.innerHTML = node.name;
            //Delete the specified subtree 
            //when clicking on a label.
            //Only apply this method for nodes
            //in the first level of the tree.
            style.cursor = 'pointer';
            label.onclick = function() {
                if ( node._depth != 0 ) {

                }else{
                    
                }
                /*
                if(!removing) {
                    removing = true;
                    Log.write("removing subtree...");  
                    //remove the subtree
                    st.removeSubtree(label.id, true, 'animate', {
                        hideLabels: false,
                        onComplete: function() {
                          removing = false;
                          Log.write("subtree removed");   
                        }
                    });
                }
                */
            }
        },
        //This method is triggered right before plotting a node.
        //This method is useful for adding style 
        //to a node before it's being rendered.
        onBeforePlotNode: function(node) {
            //if (node._depth == 1) {
                node.data.$color = '#f77';
            //}
        }
    });
    //load json data
    st.loadJSON(json);
    //compute node positions and layout
    st.compute();
    //optional: make a translation of the tree
    st.geom.translate(new $jit.Complex(-200, 0), "current");
    //Emulate a click on the root node.
    st.onClick(st.root);
    //end
    /*
    //init handler
    //Add an event handler to the add button for
    //adding a subtree.
    var animate = document.getElementById('animate');
    var addButton = document.getElementById('addSubtree');
    addButton.onclick = function() {
        var type = animate.checked? "animate" : "replot";
        subtree.id = "node02";
        Log.write("adding subtree...");  
        //add the subtree
        st.addSubtree(subtree, type, {
            hideLabels: false,
            onComplete: function() {
                Log.write("subtree added");
            }
        });
    };*/
    //end
}
