import React, { Component } from 'react'

class Projectitem extends Component {
    render() {
        return (
                                            
                                 <div className="container">
                                     <div className="card card-body bg-light mb-3">
                                         <div className="row">
                                             <div className="col-2">
                                                 <span className="mx-auto">REACT</span>
                                             </div>
                                             <div className="col-lg-6 col-md-4 col-8">
                                                 <h3>ESB / Management Console</h3>
                                                 <p>Service Configuration for Banks</p>
                                             </div>
                                             <div className="col-md-4 d-none d-lg-block">
                                                 <ul className="list-group">
                                                     <a href="#">
                                                         <li className="list-group-item board">
                                                             <i className="fa fa-flag-checkered pr-1"> Service Board </i>
                                                         </li>
                                                     </a>
                                                     <a href="#">
                                                         <li className="list-group-item update">
                                                             <i className="fa fa-edit pr-1"> Update Service Info</i>
                                                         </li>
                                                     </a>
                                                     <a href="">
                                                         <li className="list-group-item delete">
                                                             <i className="fa fa-minus-circle pr-1"> Delete Service</i>
                                                         </li>
                                                     </a>
                                                 </ul>
                                             </div>
                                         </div>
                                     </div>
                                 </div>
                                 
        )
    }
}

export default Projectitem;
