import React, { forwardRef, HTMLAttributes } from 'react'

/**
 * This is container props for the storing the custom props.
 */
interface PContainerProps extends HTMLAttributes<HTMLDivElement> {
    /**
  * A string of all className you want applied to the base component. [docs]
  */
    className?: string
  /**
   * Set container 100% wide until small breakpoint. [docs]
   */
    sm?: boolean
/**
   * Set container 100% wide until medium breakpoint. [docs]
   */
 
    md?: boolean
/**
   * Set container 100% wide until large breakpoint. [docs]
   */

    lg?: boolean

    /**
   * Set container 100% wide until X-large breakpoint. [docs]
   */
  xl?: boolean
  /**
   * Set container 100% wide until XX-large breakpoint. [docs]
   */
  xxl?: boolean
  /**
   * Set container 100% wide, spanning the entire width of the viewport. [docs]
   */
  fluid?: boolean
    
}

const BREAKPOINTS = [
    'xxl' as const,
    'xl' as const,
    'lg' as const,
    'md' as const,
    'sm' as const,
    'fluid' as const,
  ]

export default PContainerProps;
export {BREAKPOINTS};