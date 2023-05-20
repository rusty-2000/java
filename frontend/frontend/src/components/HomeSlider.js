import React, { Component } from "react";
import { Slide } from "react-slideshow-image";

//importing the images
import slide1 from "../resources/slider1.jpg";
import slide2 from "../resources/slider3.jpg";
import slide3 from "../resources/slider11.jpg";

//save it to an array
const slideImages = [slide1, slide2, slide3];

//slider properties
const properties = {
  duration: 5000,
  transitionDuration: 500,
  infinite: true,
  indicators: true,
  arrows: true
};

export default class HomeSlider extends Component {
  render() {
    return (
      <div className="slider" style={{ width: 1280 }}>
        <Slide {...properties}>
          <div className="each-slide">
            <div
              style={{
                
                backgroundImage: `url(${slideImages[0]})`,backgroundSize:"1280px 600px",
                backgroundRepeat: "no-repeat",
                
                height: 520
              }}
            >
              
            </div>
          </div>
          <div className="each-slide">
            <div
              style={{ backgroundImage: `url(${slideImages[1]})`, 
              backgroundRepeat: "no-repeat",backgroundSize:"1600px 600px" ,height: 520 }
              }
            
            >
              
            </div>
          </div>
          <div className="each-slide">
            <div
              style={{ backgroundImage: `url(${slideImages[2]})`,
              backgroundRepeat: "no-repeat",backgroundSize:"1600px 600px" , height: 520 }}
            >
             
            </div>
            </div>
        </Slide>
      </div>
    );
  }
}
