import React,{ forwardRef, HTMLAttributes} from 'react'
import PContainerProps, { BREAKPOINTS } from './PContainerProps'
import PropTypes from 'prop-types'
import classNames from 'classnames'



 const PContainer = forwardRef<HTMLDivElement, PContainerProps>(
({children,className,...rest},ref) =>{
  /**
   * Array for stroing the multiple classname in the variable.This is come wih the parent component.
   */
  const repsonsiveCLassNames: string[] = []

  BREAKPOINTS.forEach((bp)=>{
    const breakpoint = rest[bp]
    delete rest[bp]

    breakpoint && repsonsiveCLassNames.push('container-${bp}')
  })


  const _className = classNames(
    repsonsiveCLassNames.length ? repsonsiveCLassNames : 'container',
    className,
  )

  return (
    <div className={_className} {...rest} ref={ref}> 
      <p>Hello from container</p>{children}
    </div>
  )
}
);

PContainer.propTypes = {
    children: PropTypes.node,
    className: PropTypes.string,
    sm: PropTypes.bool,
    md: PropTypes.bool,
    lg: PropTypes.bool,
    xl: PropTypes.bool,
    xxl: PropTypes.bool,
    fluid: PropTypes.bool,
  }
  
  export default PContainer;